package br.com.alura.aluraflix.controller;

import br.com.alura.aluraflix.dto.request.RequestVideoDto;
import br.com.alura.aluraflix.dto.response.ResponseVideoDto;
import br.com.alura.aluraflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

    @GetMapping("/{id}")
    public ResponseEntity<ResponseVideoDto> getById(@PathVariable Long id) {
        ResponseVideoDto video = videoService.getById(id);
        return ResponseEntity.ok(video);
    }

    @PostMapping
    public ResponseEntity<ResponseVideoDto> post(@RequestBody @Valid RequestVideoDto video, UriComponentsBuilder componentsBuilder) {
        ResponseVideoDto videoDto = videoService.post(video);
        URI uri = componentsBuilder.path("videos/{id}").buildAndExpand(videoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(videoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseVideoDto> update(@RequestBody @Valid RequestVideoDto video, @PathVariable Long id) {
        ResponseVideoDto update = videoService.update(video, id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        videoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
