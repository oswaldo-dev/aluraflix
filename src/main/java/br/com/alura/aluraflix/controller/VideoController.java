package br.com.alura.aluraflix.controller;

import br.com.alura.aluraflix.dto.response.ResponseVideoDto;
import br.com.alura.aluraflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<Page<ResponseVideoDto>> get(Pageable pageable) {
        Page<ResponseVideoDto> videos = videoService.get(pageable);
        return ResponseEntity.ok(videos);
    }
}
