package com.markettime.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.markettime.aop.LoggedIn;
import com.markettime.model.dto.MessageDto;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping("messages")
public class MessagesController {

    private static final String MESSAGE_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    /**
     *
     * @return
     */
    @LoggedIn
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMessages() {
        return new ModelAndView("messages", "messages", createMessagesList());
    }

    private List<MessageDto> createMessagesList() {
        List<MessageDto> messages = new ArrayList<>();
        messages.add(new MessageDto(1L, "First Message", MESSAGE_CONTENT, "07/02/2017", false));
        messages.add(new MessageDto(1L, "Second Message", MESSAGE_CONTENT, "06/02/2017", true));
        messages.add(new MessageDto(1L,
                "Very long long long long long long long long long long long long long long long long long long long long long long long long long long long long title",
                MESSAGE_CONTENT, "06/02/2017", true));
        return messages;
    }

}
