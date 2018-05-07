package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    /*@Test
    public void trelloMaptoBoardTest()  {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("board name", "test_id", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);
        //When
        List<TrelloBoard> mappedBoard = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        Assert.assertEquals(1, mappedBoard.size());
    }

    @Test
    public void trelloMaptoBoardDtoTest() {
        //Given
        TrelloBoard trelloBoard =  new TrelloBoard("board id", "board name", new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //When
        List<TrelloBoardDto> mappedToBoardDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        Assert.assertEquals(1,mappedToBoardDto.size());
    }

    @Test
    public void trelloMapToTrelloListTest() {
        //Given
        TrelloListDto tLDto = new TrelloListDto("ListDto id","ListDto name",false);
        List<TrelloListDto> tListDto = new ArrayList<>();
        tListDto.add(tLDto);

        //Then
        List <TrelloList> trelloListMapped = trelloMapper.mapToList(tListDto);

        //Given
        Assert.assertEquals(1,trelloListMapped.size());

    }

    @Test
    public void trelloMapToTrelloListDtoTest(){
        //Given
        TrelloList tL = new TrelloList("List id", "List name", false);
        List<TrelloList> tList = new ArrayList<>();
        tList.add(tL);

        //When
        List<TrelloListDto> trelloListDtoMapped = trelloMapper.mapToListDto(tList);

        //Then
        Assert.assertEquals(1,trelloListDtoMapped.size());
    }

    @Test
    public void trelloMapToTrelloCardTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Card name","Card description","Card pos", "Card id");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals("Card name",trelloCardDto.getName());
    }

    @Test
    public void trelloMapToTrelloCardDtoTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card name", "Card description", "Card pos", "Card id");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals("Card name", trelloCard.getName());
    }*/
}
