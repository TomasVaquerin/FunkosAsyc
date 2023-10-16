package dev.tomas.funtion;

import dev.tomas.models.Funko;
import dev.tomas.models.Modelo;
import dev.tomas.models.MyIDGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class readfile {

    private static readfile instance;
    private List<Funko> funkos = new ArrayList<>();
    private static Lock lock = new ReentrantLock();

    private final MyIDGenerator idGenerator = MyIDGenerator.getInstance();
    private String fichero = "funkos.csv";
    private String carpeta = "data";

    private final String ruta = "";
    public static readfile getInstance() {
        if (instance == null) {
            lock.lock();
            instance = new readfile();
            lock.unlock();
        }
        return instance;
    }

    private readfile() {

    }

    public CompletableFuture<List<Funko>> loadCsv() {
        funkos.clear();
        return CompletableFuture.supplyAsync(() -> {

            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                String line = br.readLine();
                line = br.readLine();
                while (line != null) {
                    String[] split = line.split(",");

                    UUID cod = UUID.fromString(split[0].substring(0, 35));

                    funkos.add(Funko.builder()
                            .cod(cod)
                            .myId(idGenerator.getAndIncrement())
                            .nombre(split[1])
                            .modelo(Modelo.valueOf(split[2]))
                            .precio(Double.parseDouble(split[3]))
                            .fecha_lanzamiento(generatorDia(split[4]))
                            .build());
                    line = br.readLine();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return funkos;
        });
    }

    LocalDate generatorDia(String split) {
        int año = Integer.parseInt(split.split("-")[0]);
        int mes = Integer.parseInt(split.split("-")[1]);
        int dia = Integer.parseInt(split.split("-")[2]);

        LocalDate fecha = LocalDate.of(año, mes, dia);
        return fecha;
    }
}