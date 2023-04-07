package com.project.group17.listingsTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.group17.LikeListing.entity.LikeListingEntity;
import com.project.group17.LikeListing.repository.LikeListingRepository;
import com.project.group17.listings.entity.ListingsEntity;
import com.project.group17.listings.repository.ListingsRepository;
import com.project.group17.listings.service.ListingsService;
import com.project.group17.listings.controller.ListingsController;
import com.project.group17.user.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@WebMvcTest(ListingsController.class)
@Import(TestConfig.class)
public class ListingsControllerTest
{

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @MockBean
        private ListingsService listingsService;

        @MockBean
        private LikeListingRepository likeListingRepository;

        @MockBean
        private ListingsRepository listingsRepository;

        @Test
        @WithMockUser(username = "testuser", roles = "USER")
        public void testGetAllListings() throws Exception {
            ListingsEntity listing1 = new ListingsEntity();
            // Set listing1 properties
            ListingsEntity listing2 = new ListingsEntity();
            // Set listing2 properties

            when(listingsService.getAllListings()).thenReturn(Arrays.asList(listing1, listing2));

            mockMvc.perform(get("/api/v1/getAll")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].listingId").value(listing1.getListingId()))
                    .andExpect(jsonPath("$[1].listingId").value(listing2.getListingId()));
        }

    }

