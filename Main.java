import java.util.List;

public class Main {

    public static void main(String[] args) {


        DBConnection kategori = new DBConnection();

        //DB sınıfından kategori adında nesne türettik.
        //sonrada bu nesne üzerinden metodumuzu çağırdık.
//        nesne türetmeden de baska bir sınıfta ki metoda ulasılabilir
//        fakat sınıf.metodismi derken metod static olmalıdır.


        List<Category> categories = kategori.getList();

        //buraya size 13 değilde 0 gelmesinin nedeni ben gidip yukarıda kategori.getList(); yapı
        //veritabanını attığım listeyi çağırmıştım ama sonra gidip altta
        //List<Category> categories = Arraylist<> diyerek yeni bir liste oluşturmuşum bundan kaynaklı liste boş gözüküyordu.
        //ama yukarıda ki haline getirerek artık size 13 tanesi geliyor oldu.

        yaz(categories);

    }


    public static void seviyeÇizgiÇizVeKategoriAdiYaz(int seviye, Category categories) {
        for (int i = 0; i < seviye; i++) {
            System.out.print("-");
        }
        System.out.println(categories.getName());
    }

    public static void yaz(List<Category> categories) {
        for (Category category : categories) {
            //if (category.getParentİd() == ) {
                seviyeÇizgiÇizVeKategoriAdiYaz(0, category);
                cocuklariYazdir(0, category, categories);

            }

        }


    public static void cocuklariYazdir(int seviye, Category ustKategori, List<Category> categories){
        for (Category category : categories) {
            if(ustKategori.getId() == category.getParentİd()){
                int yeniSeviye=seviye+1;
                seviyeÇizgiÇizVeKategoriAdiYaz(yeniSeviye,category);
                cocuklariYazdir(yeniSeviye,category,categories);
            }

        }
    }
    }

