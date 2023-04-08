//package com.project.group17.prefValues.controller;
//
//import com.project.group17.prefValues.controller.PrefValuesController;
//import com.project.group17.prefValues.model.PrefValueSaveReq;
//import com.project.group17.prefValues.service.PrefValuesService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(PrefValuesController.class)
//public class PrefValuesControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PrefValuesService prefValuesService;
//
//    @Test
//    public void saveUserPreferencesTest() throws Exception {
//        int userId = 1;
//        ArrayList<PrefValueSaveReq> userPrefs = new ArrayList<>();
//
//        PrefValueSaveReq prefValueSaveReq = new PrefValueSaveReq();
//        prefValueSaveReq.setPrefNameId(1L);
//        prefValueSaveReq.setPrefOptionId(5L);
//        userPrefs.add(prefValueSaveReq);
//
//        // Mock the service method
//        when(prefValuesService.saveUserPreferences(userId, userPrefs)).thenReturn("Success");
//
//        // Call the service method directly
//        String actualResult = prefValuesService.saveUserPreferences(userId, userPrefs);
//
//        // Assert that the expected and actual result match
//        assertEquals("Success", actualResult);
//    }
//}