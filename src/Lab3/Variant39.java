package Lab3;

import java.util.Arrays;
import java.util.Objects;

// Создать приложение, удовлетворяющее требованиям, приведенным в задании.
// Аргументировать принадлежность классу каждого создаваемого метода и
// корректно переопределить для каждого класса методы equals(), hashCode(), toString().
// Создать объект класса Фотоальбом, используя класс Фотография.
// Методы: задать название фотографии, дополнить фотоальбом фотографией,
// вывести на консоль количество фотографий.

class Photo {
    private String name, sizes;

    public Photo(String name, String sizes) {
        this.name = name;
        this.sizes = sizes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        return Objects.equals(((Photo) o).name, name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class PhotoAlbum {
    private Photo[] photos;

    public PhotoAlbum() {
        photos = new Photo[]{};
    }

    public void setName(String name, int index) {
        if (index < 0 || index >= this.photos.length) return;

        this.photos[index].setName(name);
    }

    public void append(Photo p) {
        var t = new Photo[this.photos.length + 1];

        System.arraycopy(this.photos, 0, t, 0, photos.length);
        t[t.length - 1] = p;

        this.photos = t;
    }

    public void printCount() {
        System.out.println("Количество: " + this.photos.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoAlbum)) return false;
        return Arrays.equals(((PhotoAlbum) o).photos, photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash((Object) photos);
    }

    @Override
    public String toString() {
        return this.photos[0].getName();
    }
}

public class Variant39 {
    public static void main(String[] args) {
        PhotoAlbum album = new PhotoAlbum();

        album.append(new Photo("1", "1x2"));
        album.append(new Photo("1", "2x2"));
        album.append(new Photo("1", "3x2"));

        album.printCount();
    }
}
