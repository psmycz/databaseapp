-- uwaga bo wyjebie sie jak np. przypisze przylacze do nieistniejacej sali np. przylacze(salaId = 8), a nie ma sali o takim id
-- do sprawdzenia

insert into sala (numer, budynek) values (63,'A');
insert into sala (numer, budynek) values (112,'D');
insert into sala (numer, budynek) values (32,'C');
insert into sala (numer, budynek, opis) values (1,'A', 'jakis opis xD');
insert into sala (numer, budynek) values (423,'B');
insert into sala (numer, budynek) values (110,'A');

insert into przylacze (sala_id, nazwa, opis) values (1,'makbert','takie o');
insert into przylacze (sala_id, nazwa, opis) values (3,'jakies przylacze','koment');
insert into przylacze (sala_id, nazwa) values (6,'makbert');

insert into naprawa (sala_id, data_naprawy, opis) values (1,SYSDATE(),'no jeblo sie cos ^^');
insert into naprawa (sala_id, data_naprawy) values (1,SYSDATE());
insert into naprawa (sala_id, data_naprawy, opis) values (4,SYSDATE(),'^^');

insert into ekran (sala_id, model, wymiary,sterowanie,opis) values (1,'jakis model','2x3','reczne xD','nie ma');
insert into ekran (sala_id, model, wymiary,sterowanie,opis) values (2,'model','3x3',' xD','nie ma');
insert into ekran (sala_id, model, wymiary,sterowanie,opis) values (2,'jakis model','4x3',NULL,NULL );

insert into audio (sala_id,typ, opis) values ( 2, 'typikal','opis');
insert into audio (sala_id,typ, opis) values ( 2, 'malware','no');
insert into audio (sala_id,typ, opis) values ( 1, 'typ',NULL);
insert into audio (sala_id,typ, opis) values ( 5, 'mikrofon','aha');
insert into audio (sala_id,typ, opis) values ( 1, 'mikrofony','bach');

insert into automatyka (sala_id, nazwa, opis) values ( 1, 'szafa1','szafa');
insert into automatyka (sala_id, nazwa, opis) values ( 1, 'szafa2',NULL);
insert into automatyka (sala_id, nazwa, opis) values ( 2, 'szafa3',NULL);
insert into automatyka (sala_id, nazwa, opis) values ( 1, 'szafa4','opis');

insert into tablica (sala_id,model,wymiary,opis) values (3,'model11','3x5',NULL);
insert into tablica (sala_id,model,wymiary,opis) values (2,'model12','5x5',NULL);
insert into tablica (sala_id,model,wymiary,opis) values (1,'model12','4x5','opis');

insert into visualizer (sala_id, model, opis) values (1,'visualStudio to gunwo', 'jeb sie na ryj');
insert into visualizer (sala_id, model, opis) values (2,'2', NULL);
insert into visualizer (sala_id, model, opis) values (6,'1', 'opis');

insert into wyposazenie (sala_id, rolety, oswietlenie, pilot, inne, opis) values ( 1,'no som','cos swieci','nie ma','sam jestes inny','po ki uj');
insert into wyposazenie (sala_id, rolety, oswietlenie, pilot, inne, opis) values ( 2,'nie ma ',NULL,NULL,'inny',NULL);
insert into wyposazenie (sala_id, rolety, oswietlenie, pilot, inne, opis) values ( 3,'som','swieci','ma','hieroglify','plakat andrzeja dudy wisi na scianie');

insert into zlacze (sala_id, nazwa, dlugosc, opis) values (1,'usb',5.5,NULL);
insert into zlacze (sala_id, nazwa, dlugosc, opis) values (1,'hdmi',5,'trzeba?');
insert into zlacze (sala_id, nazwa, dlugosc, opis) values (1,'vga',2,'zwykly kabel');

insert into projektor(sala_id,model,numer_seryjny,adres_ip,adres_mac,wersja_oprogr,opis) values (1,'sad','123xD','1.1.1.1','ad:ad:ad:ad:ad:ad','1.4.521',NULL);
insert into projektor(sala_id,model,numer_seryjny,adres_ip,adres_mac,wersja_oprogr,opis) values (1,'bad','124xD','1.1.1.2','ad:ad:ad:ad:ad:bd','1.4.521','opis');
insert into projektor(sala_id,model,numer_seryjny,adres_ip,adres_mac,wersja_oprogr,opis) values (2,'mad','125xD','1.1.1.3','ad:ad:ad:ad:ad:cd','1.4.521',NULL);

insert into lampa (projektor_id,czas_pracy,data_kontroli,sprawna,opis) values (1,5555,sysdate(),false,NULL);
insert into lampa (projektor_id,czas_pracy,data_kontroli,sprawna,opis) values (1,24,sysdate(),true,NULL);
insert into lampa (projektor_id,czas_pracy,data_kontroli,sprawna,opis) values (2,0,sysdate(),true,'no dziala');