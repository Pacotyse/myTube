package com.mytube;

public class VideoProcessor {
    public VideoProcessor(VideoEncoder encoder) {
        this.encoder = encoder;
    }

    private VideoEncoder encoder;
    public void process(Video video) {
        encoder.encode(video);

        var database = new VideoDatabase();
        database.store(video);

        var emailService = new EmailService();
        emailService.sendEmail(video.getUser());
    }
}

