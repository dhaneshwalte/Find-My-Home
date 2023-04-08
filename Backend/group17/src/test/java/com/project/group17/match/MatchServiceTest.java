package com.project.group17.match;

import com.project.group17.group.entity.GroupEntity;
import com.project.group17.group.repository.GroupRepository;
import com.project.group17.group.service.GroupService;
import com.project.group17.location.entity.LocationEntity;
import com.project.group17.location.service.LocationService;
import com.project.group17.location.service.LocationServiceTest;
import com.project.group17.match.entity.*;
import com.project.group17.match.repository.*;
import com.project.group17.match.service.MatchService;
import com.project.group17.prefNames.entity.PrefNamesEntity;
import com.project.group17.prefOptions.controller.PrefOptionsController;
import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import com.project.group17.prefValues.entity.PrefValuesEntity;
import com.project.group17.prefValues.service.PrefValuesService;
import com.project.group17.user.entity.User;
import com.project.group17.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.mockito.ArgumentMatchers;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@ExtendWith(MockitoExtension.class)
class MatchServiceTest {

    @InjectMocks
    private MatchService matchService;

    @Mock
    private LocationService locationService;

    @Mock
    private PrefValuesService prefValuesService;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private GroupService groupService;

    @Mock
    private MatchRepository matchRepository;

    @Mock
    private Authentication authentication;

    private User user1;
    private User user2;
    private MatchPojo matchPojo;
    private MatchEntity matchEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        user1 = new User();
        user1.setId(1);
        user1.setFirstname("John");
        user1.setLastname("Doe");
        user1.setCity("New York");
        user1.setProvince("NY");

        user2 = new User();
        user2.setId(2);
        user2.setFirstname("Jane");
        user2.setLastname("Doe");
        user2.setCity("Los Angeles");
        user2.setProvince("CA");

        matchPojo = new MatchPojo();
        matchPojo.setUser2ID(user2.getId());

        matchEntity = new MatchEntity();
        matchEntity.setUser1(user1);
        matchEntity.setUser2(user2);
    }

    @Test
    void testGetUserId() {
        when(userRepository.findById(user2.getId())).thenReturn(Optional.of(user2));
        when(matchRepository.findByUser1(user2)).thenReturn(Collections.emptyList());

        matchService.getUserId(matchPojo);

        verify(matchRepository, times(1)).save(any(MatchEntity.class));
        verify(groupService, never()).saveGroup(user1, user2);
    }

//    @Test
//    void testLikes() {
//
//        User currentUser = new User(); // Create a user object with the necessary fields.
//        Mockito.when(authentication.getPrincipal()).thenReturn(currentUser);
//
//        List<MatchEntity> matches = Collections.singletonList(matchEntity);
//        Mockito.when(matchRepository.findByUser1(user1)).thenReturn(matches);
//
//        currentUser.setId(1); // Set the user's ID.
//        // Set other properties of the currentUser object, if necessary.
//
//        Mockito.when(authentication.getPrincipal()).thenReturn(currentUser);
//
//        // Use an argument matcher when defining your stub.
//        Mockito.when(matchRepository.findByUser1(ArgumentMatchers.any(User.class))).thenReturn(new ArrayList<>());
//
//        ResponseEntity<List<Map<String, String>>> result = matchService.likes();
//
//        assertEquals(1, result.getBody().size());
//        assertEquals(user2.getFirstname(), result.getBody().get(0).get("firstName"));
//        assertEquals(user2.getLastname(), result.getBody().get(0).get("lastName"));
//    }

    @Test
    void testGetUserPreferences() {
        PrefNamesEntity prefNameEntity = new PrefNamesEntity();
        prefNameEntity.setName("Furnished");

        PrefOptionsEntity prefOptionEntity = new PrefOptionsEntity();
        prefOptionEntity.setOption("Yes");

        PrefValuesEntity prefValuesEntity = new PrefValuesEntity();
        prefValuesEntity.setUser(user1);
        prefValuesEntity.setPrefName(prefNameEntity);
        prefValuesEntity.setPrefOption(prefOptionEntity);

        when(prefValuesService.findAll()).thenReturn(Collections.singletonList(prefValuesEntity));

        Map<User, Map<String, String>> result = matchService.getUserPreferences();

        assertEquals(1, result.size());
        assertEquals("Yes", result.get(user1).get("Furnished"));
    }

    @Test
    void testGetUserInfoAndPreferences() {
        PrefNamesEntity prefNameEntity = new PrefNamesEntity();
        prefNameEntity.setName("Furnished");

        PrefOptionsEntity prefOptionEntity = new PrefOptionsEntity();
        prefOptionEntity.setOption("Yes");

        PrefValuesEntity prefValuesEntity = new PrefValuesEntity();
        prefValuesEntity.setUser(user1);
        prefValuesEntity.setPrefName(prefNameEntity);
        prefValuesEntity.setPrefOption(prefOptionEntity);

        when(prefValuesService.findAll()).thenReturn(Collections.singletonList(prefValuesEntity));

        Map<String, String> result = matchService.getUserInfoAndPreferences(user1);

        assertEquals(user1.getFirstname(), result.get("firstName"));
        assertEquals(user1.getLastname(), result.get("lastName"));
        assertEquals("Yes", result.get("Furnished"));
    }

    @Test
    void testGetRoommateList_userInGroup() {
        when(groupRepository.findByUser(user1)).thenReturn(Collections.singletonList(new GroupEntity()));

        List<Map<String, String>> result = matchService.getRoommateList(user1);

        assertNull(result);
    }

    @Test
    void testGetRoommateList_noGroup() {
        when(groupRepository.findByUser(user1)).thenReturn(Collections.emptyList());
        when(prefValuesService.findAll()).thenReturn(Collections.emptyList());

        List<Map<String, String>> result = matchService.getRoommateList(user1);

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testGetAllUserInfoAndPreferences() {
        PrefNamesEntity prefNameEntity = new PrefNamesEntity();
        prefNameEntity.setName("Furnished");

        PrefOptionsEntity prefOptionEntity = new PrefOptionsEntity();
        prefOptionEntity.setOption("Yes");

        PrefValuesEntity prefValuesEntity = new PrefValuesEntity();
        prefValuesEntity.setUser(user1);
        prefValuesEntity.setPrefName(prefNameEntity);
        prefValuesEntity.setPrefOption(prefOptionEntity);

        when(prefValuesService.findAll()).thenReturn(Collections.singletonList(prefValuesEntity));

        List<Map<String, String>> result = matchService.getAllUserInfoAndPreferences(Collections.singletonList(user1));

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(user1.getFirstname(), result.get(0).get("firstName"));
        assertEquals(user1.getLastname(), result.get(0).get("lastName"));
        assertEquals("Yes", result.get(0).get("Furnished"));
    }
    
}

