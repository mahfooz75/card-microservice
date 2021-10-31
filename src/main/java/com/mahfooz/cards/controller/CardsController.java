package com.mahfooz.cards.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mahfooz.cards.model.Cards;
import com.mahfooz.cards.model.Customer;
import com.mahfooz.cards.repository.CardsRepository;

@RestController
public class CardsController {
  @Autowired
  private CardsRepository cardsRepository;

  @PostMapping("/myCards")
  public List<Cards> getCardDetails(@RequestBody Customer customer) {
    List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
    if (cards != null) {
      return cards;
    } else {
      return null;
    }

  }
}
