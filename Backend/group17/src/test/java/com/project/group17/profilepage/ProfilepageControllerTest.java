//package com.project.group17.profilepage;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.group17.config.JwtService;
//import com.project.group17.listings.controller.LikeListingController;
//import com.project.group17.match.service.MatchService;
//import com.project.group17.profilepage.controller.ProfileController;
//import com.project.group17.profilepage.controller.UserUpdateRequest;
//import com.project.group17.profilepage.service.ProfileService;
//import com.project.group17.user.entity.User;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = LikeListingController.class)
//@AutoConfigureMockMvc(addFilters = false)
//public class ProfilepageControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//    @MockBean
//    private JwtService jwtService;
//    @MockBean
//    private ProfileController profileController;
//
//    @MockBean
//    private MatchService matchService;
//
//    @MockBean
//    private ProfileService profileService;
//
//    @BeforeEach
//    public void setUp() {
//        User user = new User();
//        user.setId((int) 1);
//        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//        SecurityContextHolder.getContext().setAuthentication(auth);
//    }
//
//    @Test
//    public void testSayHello()  {
////        mockMvc.perform(post("/api/v1/profilepage")).contentType(MediaType.APPLICATION_JSON)
////                .content(ObjectMapper.writeValues)
//        User user = new User();
//        user.setId((int) 1);
//        Map<String, String> expectedResponse = new HashMap<>();
//        expectedResponse.put("id", "1");
//        expectedResponse.put("firstName", "John");
//        expectedResponse.put("lastName", "Doe");
//        expectedResponse.put("email", "johndoe@example.com");
//        when(matchService.getUserInfoAndPreferences(user)).thenReturn(expectedResponse);
//        Authentication auth = new UsernamePasswordAuthenticationToken(user, null);
//        SecurityContextHolder.getContext().setAuthentication(auth);
//        ResponseEntity<Map<String, String>> response = profileController.sayHello();
//        verify(matchService).getUserInfoAndPreferences(user);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(expectedResponse, response.getBody());
//    }
//
//    @Test
//    public void testSaveEditUserDetails() {
//        User principleUser = new User();
//        principleUser.setId((int)1);
//        UserUpdateRequest updatedUser = new UserUpdateRequest();
//        updatedUser.setFirstname("Jane");
//        updatedUser.setLastname("Doe");
//        updatedUser.setGender("Female");
//        updatedUser.setEmail("janedoe@example.com");
//        updatedUser.setStreetAddress("123 Main St");
//        updatedUser.setCity("Anytown");
//        updatedUser.setProvince("CA");
//        updatedUser.setPhoneNumber("555-555-5555");
//        updatedUser.setAge("30");
//        doNothing().when(profileService).saveEditUserDetails(updatedUser, principleUser);
//        Authentication auth = new UsernamePasswordAuthenticationToken(principleUser, null);
//        SecurityContextHolder.getContext().setAuthentication(auth);
//        String response = profileController.saveEditUserDetails(updatedUser);
//        verify(profileService).saveEditUserDetails(updatedUser, principleUser);
//        assertEquals("SUCCESS", response);
//    }
//}
