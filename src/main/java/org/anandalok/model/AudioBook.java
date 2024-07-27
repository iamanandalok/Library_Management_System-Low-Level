package org.anandalok.model;

public class AudioBook extends Book {
    private String audioSample;

    public AudioBook(String title, String author, String ISBN, int publicationYear, String audioSample) {
        super(title, author, ISBN, publicationYear);
        this.audioSample = audioSample;
    }

    public String getAudioSample() {
        return audioSample;
    }

    public void setAudioSample(String audioSample) {
        this.audioSample = audioSample;
    }
}

