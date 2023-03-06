package pl.mateuszkolodziejczyk.recruitmenttask.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateuszkolodziejczyk.recruitmenttask.domain.Word;
import pl.mateuszkolodziejczyk.recruitmenttask.domain.WordDetails;
import pl.mateuszkolodziejczyk.recruitmenttask.service.TextService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/text")
@RequiredArgsConstructor
public class TextApi {

    private final TextService textService;

    @PostMapping("/map")
    public ResponseEntity<Map<String, WordDetails>> analyzeToMap(@RequestBody String str) {
        Map<String, WordDetails> words = textService.analyzeToMap(str);
        return ResponseEntity.status(HttpStatus.OK).body(words);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Word>> analyzeToList(@RequestBody String str) {
        List<Word> words = textService.analyzeToList(str);
        return ResponseEntity.status(HttpStatus.OK).body(words);
    }
}
