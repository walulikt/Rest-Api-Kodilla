package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards= trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(i->i.getId()!= null)
                .filter(n->n.getName()!=null)
                .filter(k->k.getName().startsWith("Kod"))
                .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println("This board contains lists: ");
            trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
        });
                return trelloBoards;
    }

   /* @RequestMapping (method = RequestMethod.POST,value = "createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloClient.createNewCard(trelloCardDto);
    }*/

    @RequestMapping (method = RequestMethod.POST,value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        CreatedTrelloCard trelloCard = trelloClient.createNewCard(trelloCardDto);
        System.out.println (trelloCard.getId() + " " + trelloCard.getName() + " " + trelloCard.getShortUrl());

       // System.out.println(trelloCard.getTrelloBadgesDto().getAttachmentsByTypeDto().getTrelloDto().getBoard());
        //System.out.println(trelloCard.getTrelloBadgesDto().getAttachmentsByTypeDto().getTrelloDto().getCard());

        return trelloCard;
    }

}