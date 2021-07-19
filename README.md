# Production_rule_system

Definovanie problému

Úlohou je vytvoriť jednoduchý dopredný produkčný systém, s prípadnými 
rozšíreniami, napríklad o kladenie otázok používateľovi alebo vyhodnocovanie 
matematických výrazov.
Produkčný systém patrí medzi znalostné systémy, teda medzi systémy, ktoré so 
svojimi údajmi narábajú ako so znalosťami. Znalosti vyjadrujú nielen informácie o 
nejakom objekte, ale aj súvislosti medzi objektami, vlastnosti zvolených problémov 
a spôsoby hľadania ich riešenia. Znalostný systém je teda v najjednoduchšom 
prípade dvojica – program, ktorý dokáže všeobecne manipulovať so znalosťami a 
báza znalostí, ktorá opisuje problém a vzťahy, ktoré tam platia. Znalosti majú 
definovanú nejakú štruktúru a spôsob narábania s touto štruktúrou – to sa nazýva 
formalizmus reprezentácie znalostí. Program vie pracovať s týmto 
formalizmom, ale nesmie byť závislý od toho, aké konkrétne znalosti 
spracováva, inak by to už nebol systém, kde riešenie úlohy je dané použitými 
údajmi.
Produkčný systém na základe odvodzovacieho pravidla modus ponens (pravidlo 
odlúčenia) odvodzuje zo známych faktov a produkčných pravidiel nové fakty. Ak 
systém nemá dostatok vstupných údajov, môže klásť používateľovi otázky.
Produkčný systém ako program nepozná konkrétne pravidlá ani fakty! Pozná 
len formalizmus, v tomto prípade štruktúru pravidiel a faktov a spôsob ich 
spracovania. Pozná akcie (pridaj, vymaž, ...), ktoré sa môžu vykonávať, lebo tie 
patria do opisu formalizmu

Reprezentacia faktov a pravidlov v textovom dokumente

Fakty : 

(toto je fakt)

Pravidlo má tri časti:

• meno

• podmienka

• akcie

Meno je identifikátorom pravidla a používa sa na sledovanie priebehu inferencie –
je vhodné, aby systém mal jednoduchý aj rozšírený (debug, verbal) režim.Podmienka je konjunkciou elementárnych podmienok, to znamená, že podmienka 
pravidla je splnená, ak sú splnené všetky elementárne podmienky a nenastal 
konflikt v žiadnej premennej.

Elementárna podmienka je buď vzorom faktu (môže obsahovať premenné)

(?a co je fakt)

alebo je to špeciálna podmienka

(<> ?a ?b)

ktorá sa rozpozná na základe tvaru.

Elementárna podmienka je splnená, ak sa zhoduje s niektorým faktom. Ak je 
to špeciálna podmienka, tak musí byť splnený ňou definovaný vzťah.

Horeuvedená špeciálna podmienka je splnená, ak sa hodnota a nezhoduje s 
hodnotou b.

Poznámka: špeciálne podmienky sa vyhodnocujú nakoniec, keď sú už hodnoty 
všetkých premenných známe.

Akcie produkčného pravidla predstavujú zoznam akcií, ktoré sa aktivujú, ak je 
pravidlo určené na vykonanie. Pravidlá môžu obsahovať tri základné typy akcií:

• PRIDAJ vzor

• VYMAZ vzor

• SPRAVA text

Môj systém funguje len na rodinu keďže hľadá také premenná čo začínajú s „?a“ 
(tu a môže byt ľubovoľne písmeno ale aj slovo).

Algoritmus

1. Načítava zoznam faktov a zoznam pravidiel zo .txt fajly .

2. Vytvorí zoznam všetkých aplikovateľných inštancii pravidiel.

3. Naviaže všetky premenná podlá faktov.

4. Vyrieši špeciálne pravidla.

5. Vykoná príkaz keď môže.

6. Vypíše fakty.

Test 01 : 

Používam obsah zo súboru : Fakty.txt a Pravidlo.txt

Výstup :

Maria ma stryka

Viera ma stryka


Peter je rodic Jano

Peter je rodic Vlado

manzelia Peter Eva

Vlado je rodic Maria

Vlado je rodic Viera

muz Peter

muz Jano

muz Vlado

zena Eva

Eva je rodic Jano

Eva je rodic Vlado

Peter je otec Jano

Peter je otec Vlado

Vlado je otec Maria

Vlado je otec Viera

Eva je matka Jano

Eva je matka Vlado

Jano a Vlado su surodenci

Vlado a Jano su surodenci

Maria a Viera su surodenci

Viera a Maria su surodenci

Jano je brat Vlado

Vlado je brat Jano

Jano je stryko Maria

Jano je stryko Viera

