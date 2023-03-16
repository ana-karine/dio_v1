public class Usuario {
    public static void main(String[] args) throws Exception {
        
        SmartTv smartTv = new SmartTv();

        System.out.println("TV Ligada? " + smartTv.ligada); // false
        System.out.println("Canal Atual? " + smartTv.canal); // 1
        System.out.println("Volume Atual? " + smartTv.volume); // 25

        smartTv.ligar();
        System.out.println("TV Ligada? " + smartTv.ligada); // true
        
        smartTv.diminuirVolume(); // 24
        smartTv.diminuirVolume(); // 23
        smartTv.diminuirVolume(); // 22
        smartTv.aumentarVolume(); // 23
        System.out.println("Volume Atual? " + smartTv.volume); // 23

        smartTv.mudarCanal(13);
        System.out.println("Canal Atual? " + smartTv.canal); // 13
    }
}
