package com.project.group17.prefOptions.controller;

import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import com.project.group17.prefOptions.service.PrefOptionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PrefOptionsControllerTest {

    @InjectMocks
    private PrefOptionsController controller;

    @Mock
    private PrefOptionsService service;

    private List<PrefOptionsEntity> prefOptionsList;

    @BeforeEach
    public void setUp() {
        PrefOptionsEntity prefOption1 = new PrefOptionsEntity();
        prefOption1.setPrefId(1L);
        prefOption1.setOption("Option 1");

        PrefOptionsEntity prefOption2 = new PrefOptionsEntity();
        prefOption2.setPrefId(2L);
        prefOption2.setOption("Option 2");

        prefOptionsList = Arrays.asList(prefOption1, prefOption2);
    }

    @Test
    public void testGetAllPrefOptions() {
        when(service.getAllPrefOptions()).thenReturn(prefOptionsList);

        ResponseEntity<List<PrefOptionsEntity>> response = controller.getAllPrefOptions();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prefOptionsList, response.getBody());
    }
}
