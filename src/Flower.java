import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;




class Flower implements Serializable {
    String name;
    String colour;
    static int cost;
    static int total;

    Flower(String name, String colour, int cost) {
        this.name = name;
        this.colour = colour;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public String getColour() {
        return colour;
    }
    public int getCost() {
        return cost;
    }


    public void print() {

        System.out.print("In CuteFlowerStore you will find a ");

    }

    public void printCharacteristics() {

        System.out.println(name + " of " + colour + " colour are available only, " + cost + " pounds");

    }
   public String toString() {
        return name + " " + colour + " " + cost;
    }



    static class Daffodil extends Flower implements Serializable {

        Daffodil(String name, String colour, int cost) {
            super(name, colour, cost);
            System.out.println("Note:");
            total += cost;
        }




    }
    static class Rose extends Flower implements Serializable {

        Rose(String name, String colour, int cost) {
            super(name, colour, cost);
            total += cost;
        }

    }

    static class Chamomile extends Flower implements Serializable {

        Chamomile(String name, String colour, int cost) {
            super(name, colour, cost);
            total += cost;
        }


    }

    static class Cactus extends Flower implements Serializable {

        Cactus(String name, String colour, int cost) {
            super(name, colour, cost);
            total += cost;
        }

    }

    public static Object deserData(String file_name) {
        Object retObject = null;

        try {
            FileInputStream fileIn = new FileInputStream(file_name + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObject = in .readObject();
            fileIn.close(); in .close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);

        } catch (IOException e) {
            System.out.println("Input/Output error");
            System.exit(2);
        } catch (ClassNotFoundException e) {
            System.out.println("Input/Output error");
            System.out.println("Class not found");
            System.exit(3);
        }
        return retObject;

    }

    public static void serData(String file_name, Object obj) {

        try {
            FileOutputStream fileOut = new FileOutputStream(file_name + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);

        } catch (IOException e) {
            System.out.println("Input/Output error");
            System.exit(2);
        }

    }



    public static class Bouquet implements Serializable {




        private static ArrayList < Flower > collection = new ArrayList < Flower > ();

        public static void main(String[] args) {

            collection = (ArrayList < Flower > ) deserData("collection");
            System.out.println(collection.size());
            Flower flower = new Flower("Flowers", "default", 100);

            collection.add(new Daffodil("Daffodils", "yellow", 20));
            collection.add(new Rose("Roses", "red", 30));
            collection.add(new Chamomile("Chamomiles", "white", 40));
            collection.add(new Cactus("Cactuses", "green", 50));
            collection.add(flower);
            for (Flower f: collection) {
                System.out.println(f.name + " of " + f.colour + " colour are available only, " + f.cost + " pounds");
            }
            System.out.println(collection);
            System.out.println(collection.size());
            serData("collection",
                    collection);



        }

    }
}