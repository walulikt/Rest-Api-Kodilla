package com.crud.tasks;

import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void getTrelloBoardsTest(){
		//Given
		//TrelloBoardDto trelloBoardDto = new TrelloBoardDto("board1", "123");
		//TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Kodilla","321");
		TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto();

		// When
		ArrayList<TrelloBoardDto> tBDto = new ArrayList<>();
		//tBDto.add(trelloBoardDto);
		//tBDto.add(trelloBoardDto1);
		tBDto.add(trelloBoardDto2);

		//Then
		tBDto.stream()
				.filter(i-> i.getId()!=null)
				.filter(n->n.getName()!=null)
				.filter(k->k.getName().startsWith("Kod"))
				.forEach(a -> System.out.println(a.getId() + " " + a.getName()));
	}

}
