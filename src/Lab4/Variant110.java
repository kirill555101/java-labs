package Lab4;

// Создать класс Cinema (кино) с внутренним классом,
// с помощью объектов которого можно хранить информацию об адресах кинотеатров, фильмах и времени сеансов.

class Cinema {
    private class Information {
        private String address, time;
        private String[] movies;

        public Information(String address, String time, String[] movies) {
            this.address = address;
            this.time = time;
            this.movies = movies;
        }
    }

    private Information[] informations = {};

    public void addInformation(String address, String time, String[] movies) {
        var t = new Information[this.informations.length + 1];

        System.arraycopy(this.informations, 0, t, 0, informations.length);
        t[t.length - 1] = new Information(address, time, movies);

        this.informations = t;
    }
}

public class Variant110 {
    public static void main(String[] args) {
        var cinema = new Cinema();
        cinema.addInformation("Moscow", "10:00-11:00", new String[]{});
    }
}
