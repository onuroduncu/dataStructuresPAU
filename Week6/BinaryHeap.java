/**
 * Minimum heap sınıfı
 * @param <T> Generic sınıf
 */
public class BinaryHeap<T extends Comparable<T>> {//dolu ikili ağaçlar
    public T[]  dizi;//Yığını tutacak dizi(değiştirmeyin)
    public int es;//Eleman sayısı(değiştirmeyin)

    public BinaryHeap() {//değiştirmeyin
        dizi=(T[]) new Comparable[100];
    }
    public BinaryHeap(int boyut){//değiştirmeyin
        dizi=(T[])new Comparable[boyut];
    }
    public int ebeveyn(int konum){ return konum/2;}//değiştirmeyin, kullanın//aşağı yuvarlanacak
    public int solCocuk(int konum){ return 2*konum;}//değiştirmeyin, kullanın
    public int sagCocuk(int konum){return 2*konum+1;}//değiştirmeyin, kullanın
    public int elemanSayisi(){return es;}

    public void ekle(T eleman){
        dizi[++es]=eleman;//dizinin en sonuna ekledik.
        int konum=es;
        while(ebeveyn(konum) >0 && dizi[ebeveyn(konum)].compareTo(dizi[konum])>0){
            int e=ebeveyn(konum);
            T gecici=dizi[e];
            dizi[e]=dizi[konum];
            dizi[konum]=gecici;
            konum=ebeveyn(konum);
        }
    }
    public T sil(){
        T donecek=dizi[1];//Kök
        int konum=1;
        dizi[konum]=dizi[es--];
        while (solCocuk(konum)<=es+1 && dizi[konum].compareTo(dizi[solCocuk(konum)])>0 || sagCocuk(konum)<=es+1 && dizi[konum].compareTo(dizi[sagCocuk(konum)])>0){
            int degisecekKonum;
            if(dizi[solCocuk(konum)].compareTo(dizi[sagCocuk(konum)])<0)
                degisecekKonum=solCocuk(konum);
            else
                degisecekKonum=sagCocuk(konum);
            T gecici=dizi[konum];
            dizi[konum]=dizi[degisecekKonum];
            dizi[degisecekKonum]=gecici;
            konum=degisecekKonum;
        }
        return donecek;
        }
    
    }
