package com.mytube;

public class VideoProcessor {
    private VideoEncoder encoder;
    private VideoDatabase database;
    private EmailService emailService;

    public VideoProcessor(
            VideoEncoder encoder,
            VideoDatabase database,
            EmailService emailService) {
        this.encoder = encoder;
        this.database = database;
        this.emailService = emailService;
    }
    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        emailService.sendEmail(video.getUser());
    }
}

