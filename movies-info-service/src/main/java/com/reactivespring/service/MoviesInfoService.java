package com.reactivespring.service;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.repository.MovieInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class MoviesInfoService {


    private MovieInfoRepository movieInfoRepository;

    public MoviesInfoService(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository = movieInfoRepository;
    }

    public Flux<MovieInfo> getAllMovieInfos(){

        return  movieInfoRepository.findAll();
    }

    public Flux<MovieInfo> getMovieInfoByYear(Integer year){

        return movieInfoRepository.findByYear(year);
    }

    public Mono<MovieInfo> addMovieInfo(MovieInfo movieInfo) {
        log.info("addMovieInfo : {} " , movieInfo );
        return movieInfoRepository.save(movieInfo)
                .log();
    }

    public Mono<MovieInfo> getMovieInfoById(String id) {
        return movieInfoRepository.findById(id);
    }

    // Übung 10
    //
    // 1 - Baue ein updateMovieInfo Methode.

    public Mono<MovieInfo> updateMovieInfo(MovieInfo movieInfo, String id) {
        // 1 - Suche die MovieInfo mit Hilfe der id im movieInfoRepository.

                // 2 - Nutze flatMap um alle Felder des Objektes zu aktualisieren.

                    // 2 - Speichere das aktualisierte Objekt.
                    return Mono.just(new MovieInfo());
    }

    public Mono<Void> deleteMovieInfoById(String id) {
        return movieInfoRepository.deleteById(id);
    }
}
