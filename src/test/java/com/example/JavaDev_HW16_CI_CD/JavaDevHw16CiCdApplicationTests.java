package com.example.JavaDev_HW16_CI_CD;

import com.example.JavaDev_HW16_CI_CD.noteprocessor.controller.NoteController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class JavaDevHw16CiCdApplicationTests {

	@Autowired
	private NoteController controller;
	@Test
		void contextLoads() { assertThat(controller).isNotNull();
	}

}
