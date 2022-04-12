public class Person implements Saveable{
    private String name;
    private String address;

    @Override
    public void save() {
        System.out.println("saving");
    }

    @Override
    public void delete() {
        System.out.println("deleting");
    }

    @Override
    public void load(String address) {
        System.out.println("loading");
    }
}
