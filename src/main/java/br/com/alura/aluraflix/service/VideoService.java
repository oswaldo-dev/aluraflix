package br.com.alura.aluraflix.service;

import br.com.alura.aluraflix.dto.request.RequestVideoDto;
import br.com.alura.aluraflix.dto.response.ResponseVideoDto;
import br.com.alura.aluraflix.model.VideoEntity;
import br.com.alura.aluraflix.repository.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Page<ResponseVideoDto> get(Pageable pageable) {
        Page<VideoEntity> all = videoRepository.findAll(pageable);
        return all.map(video -> modelMapper.map(video, ResponseVideoDto.class));
    }

    public ResponseVideoDto getById(Long id) {
        VideoEntity videoEntity = videoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(videoEntity, ResponseVideoDto.class);
    }

    public ResponseVideoDto post(RequestVideoDto video) {
        VideoEntity videoEntity = modelMapper.map(video, VideoEntity.class);
        VideoEntity save = videoRepository.save(videoEntity);
        return modelMapper.map(save, ResponseVideoDto.class);
    }

    public ResponseVideoDto update(RequestVideoDto video, Long id) {
        VideoEntity videoEntity = videoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        modelMapper.map(video, videoEntity);
        videoRepository.save(videoEntity);
        return modelMapper.map(videoEntity, ResponseVideoDto.class);
    }

    public void delete(Long id) {
        VideoEntity videoEntity = videoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        videoRepository.delete(videoEntity);
    }
}
