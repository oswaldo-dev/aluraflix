package br.com.alura.aluraflix.service;

import br.com.alura.aluraflix.dto.response.ResponseVideoDto;
import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.repository.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Page<ResponseVideoDto> get(Pageable pageable) {
        Page<Video> all = videoRepository.findAll(pageable);
        return all.map(video -> modelMapper.map(video, ResponseVideoDto.class));
    }
}
