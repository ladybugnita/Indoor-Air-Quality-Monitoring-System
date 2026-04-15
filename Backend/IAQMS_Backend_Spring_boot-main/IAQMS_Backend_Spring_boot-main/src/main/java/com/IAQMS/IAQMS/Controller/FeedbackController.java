package com.IAQMS.IAQMS.Controller;


import com.IAQMS.IAQMS.Model.FeedbackData;
import com.IAQMS.IAQMS.Repository.FeedbackRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("iaq/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;

    public FeedbackController(FeedbackRepository feedbackRepository){
        this.feedbackRepository = feedbackRepository;
    }

    @PostMapping
    public FeedbackData saveFeedbackData(@RequestBody FeedbackData feedbackData){

        System.out.println("New feedback");
        System.out.println("Name :" +feedbackData.getName());
        System.out.println("Phone Number :" +feedbackData.getPhone());
        System.out.println("Email :" +feedbackData.getEmail());
        System.out.println("Feedback message :" +feedbackData.getMessage());
         return feedbackRepository.save(feedbackData);
    }


    @GetMapping("/latest")
    public ResponseEntity<FeedbackData> getLatestFeedback(){
         FeedbackData latest = feedbackRepository.findTopByOrderByIdDesc();
         return ResponseEntity.ok(latest);
    }
}
