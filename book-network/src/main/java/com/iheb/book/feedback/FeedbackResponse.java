package com.iheb.book.feedback;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponse {

    private Double note;
    private String comment;
    private boolean ownFeedback;
}
