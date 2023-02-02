package com.example.listaprzepisow3pgr1;

import java.util.ArrayList;

public class RepozytoriumPrzepisow {
    static public final Przepis przepisy[]={
            new Przepis("mufinki",3,
                    "składniki: mleko,cukier,kakako,mąka, proszek do pieczenia,jajka, Przepisz: Wszystko wymieszać piec w temp 170",
                    R.drawable.muf),
            new Przepis("rogaliki",3,
                    "drożdże, mleko mąka jajka, marmolada",
                    R.drawable.rogalik),
            new Przepis("lody",1,
                    "mleko, cukier, owoce, wymieszać i zamrozić",
                    R.drawable.lody),
            new Przepis("kawa",0,
                    "wsypać zalać wrzątkiem",
                    R.drawable.kawa),
            new Przepis("lemoniada",0,
                    "cytryna, woda, wymieszać i schłodzić")
    } ;
    static public ArrayList<Przepis> wybierzPrzepisy(int kategoria){
      ArrayList<Przepis> wybrane = new ArrayList<>();
      for(Przepis przepisik : przepisy){
          if(przepisik.getKategoria() == kategoria){
              wybrane.add(przepisik);
          }
      }
      return  wybrane;
    }
}
