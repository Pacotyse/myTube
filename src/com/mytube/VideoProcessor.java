package com.mytube;

public class VideoProcessor {
    public VideoProcessor(VideoEncoder encoder) {
        this.encoder = encoder;
    }

    private VideoEncoder encoder;

    public VideoProcessor(VideoDatabase database) {
        this.database = database;
    }

    private VideoDatabase database;

    public VideoProcessor(EmailService emailService) {
        this.emailService = emailService;
    }

    private EmailService emailService;
    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        emailService.sendEmail(video.getUser());
    }
}

