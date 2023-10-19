package thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

final class Chat {
    private final String message;
    private final LocalDateTime timestamp;

    public Chat(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String time = timestamp.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        return time + " " + message;
    }

    

    

}
