package adapter;

interface Image {
    public void display();
}

class JPEGImage implements Image {
    @Override
    public void display() {
        System.out.println("displaying image");
    }
}

class PNGImage {
    public void show() {
        System.out.println("showing image");
    }
}

class PNGAdapter implements Image {
    private PNGImage pngImage;

    public PNGAdapter(PNGImage pngImage) {
        this.pngImage = pngImage;
    }

    @Override
    public void display() {
        pngImage.show();
    }
}

class ImageViewer {
    private Image image;

    public ImageViewer(Image image) {
        this.image = image;
    }

    public void displayImage() {
        image.display();
    }
}

class Client {
    void performAction() {
        ImageViewer imageViewer = new ImageViewer(new JPEGImage());
        imageViewer.displayImage();

        imageViewer = new ImageViewer(new PNGAdapter(new PNGImage()));
        imageViewer.displayImage();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}