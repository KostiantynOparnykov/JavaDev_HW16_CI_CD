package com.example.JavaDev_HW16_CI_CD.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class TestServiceTest {
    @Mock
    private TestService service;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testMessage(){
        Mockito.when(service.message()).thenReturn("Test Page");
        String message = service.message();
        Assertions.assertEquals("Test Page", message);
    }
}