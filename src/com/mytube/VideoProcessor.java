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
    public void process(Video video) {
        encoder.encode(video);
        database.store(video);

        var emailService = new EmailService();
        emailService.sendEmail(video.getUser());
    }
}

