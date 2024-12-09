package com.iheb.book.feedback;

import com.iheb.book.common.PageResponse;
import com.iheb.book.exception.OperationNotPermittedException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("feedbacks")
@Tag(name = "Feedback")
public class FeedBackController {

    private final FeedbackService service;

    @PostMapping
    public ResponseEntity<Integer> saveFeedback(
         @Valid @RequestBody FeedbackRequest request,
         Authentication connectedUser
    ) throws OperationNotPermittedException {
        return ResponseEntity.ok(service.save(request,connectedUser));
    }

    @GetMapping("/book/{book-id}")
    public ResponseEntity<PageResponse<FeedbackResponse>> findAllFeedbackByBook(
            @PathVariable("book-id") Integer bookId,
            @RequestParam(name = "page",defaultValue = "0",required = false) int page,
            @RequestParam(name = "size",defaultValue = "10",required = false) int size,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.findAllFeedbacksByBook(bookId,page,size,connectedUser));
    }

   
}
