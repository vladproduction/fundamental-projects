package com.epam.rd.autocode.startegy.cards;

import java.util.*;

public class CardDealingStrategies {

    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new HashMap<>();
            for (int i = 1; i <= players; i++) {
                stacks.put("Player " + i, new ArrayList<>());
            }
            for (int round = 0; round < 2; round++) {
                for (int player = 1; player <= players; player++) {
                    stacks.get("Player " + player).add(deck.dealCard());
                }
            }
            List<Card> community = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                community.add(deck.dealCard());
            }
            stacks.put("Community", community);
            stacks.put("Remaining", deck.restCards());
            return stacks;
        };
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> result = new LinkedHashMap<>();
            for (int i = 0; i < players; i++) {
                result.put("Player " + (i + 1), new ArrayList<>());
            }
            for (int cardIndex = 0; cardIndex < 5; cardIndex++) {
                for (int playerIndex = 0; playerIndex < players; playerIndex++) {
                    // Deal the card to each player in the correct order
                    result.get("Player " + (playerIndex + 1)).add(deck.dealCard());
                }
            }
            result.put("Remaining", deck.restCards());
            return result;
        };
    }

    public static CardDealingStrategy bridgeCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> result = new LinkedHashMap<>();
            for (int i = 0; i < players; i++) {
                result.put("Player " + (i + 1), new ArrayList<>());
            }
            for (int cardIndex = 0; cardIndex < 13; cardIndex++) {
                for (int playerIndex = 0; playerIndex < players; playerIndex++) {
                    result.get("Player " + (playerIndex + 1)).add(deck.dealCard());
                }
            }
            return result;
        };
    }

    public static CardDealingStrategy foolCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> result = new LinkedHashMap<>();
            List<Card> trumpCard = new ArrayList<>();
            for (int i = 0; i < players; i++) {
                result.put("Player " + (i + 1), new ArrayList<>());
            }
            for (int cardIndex = 0; cardIndex < 6; cardIndex++) {
                for (int playerIndex = 0; playerIndex < players; playerIndex++) {
                    result.get("Player " + (playerIndex + 1)).add(deck.dealCard());
                }
            }
            trumpCard.add(deck.dealCard());
            result.put("Trump card", trumpCard);
            result.put("Remaining", deck.restCards());
            return result;
        };
    }

}
