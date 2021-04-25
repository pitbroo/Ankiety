-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 22 Kwi 2021, 23:39
-- Wersja serwera: 10.4.6-MariaDB
-- Wersja PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `ankiety_db`
--

DELIMITER $$
--
-- Procedury
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADD_DATA_TO_ANKIETY` (IN `nazwaAnkiety` VARCHAR(255), IN `pytanie` VARCHAR(255))  BEGIN
INSERT INTO `ankiety` (nazwa_ankiety, pytanie)
	VALUES(nazwaAnkiety, pytanie);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ADD_DATA_TO_ODPOWIEDZI` (IN `idPytania` INT, IN `idOdpowiedzi` INT)  BEGIN
	INSERT INTO `odpowiedzi` (id_pytania, id_tresci_odpowiedzi)
    	VALUES (idPytania, idOdpowiedzi);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ADD_DATA_TO_TRESCI_ODPOWIEDZI` (IN `odpowiedz` VARCHAR(255))  BEGIN
INSERT INTO `tresci_odpowiedzi` (tresc_odpowiedzi)
	VALUES(odpowiedz);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ankiety`
--

CREATE TABLE `ankiety` (
  `ID_pytania` int(11) NOT NULL,
  `nazwa_ankiety` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `pytanie` varchar(250) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `ankiety`
--

INSERT INTO `ankiety` (`ID_pytania`, `nazwa_ankiety`, `pytanie`) VALUES
(1, 'Szkola', 'Czy lubisz chodzic do szkoly?'),
(2, 'Szkola', 'Czy Tomek zda egzamin?'),
(3, 'Szkola', 'Jaki przedmiot lubisz najbardziej?'),
(4, 'Praca', 'Ile godzin dziennie pracujesz?'),
(5, 'Praca', 'Ile zarabiasz?'),
(6, 'Praca', 'Czy chcesz zmienic swoja prace?'),
(7, 'Praca', 'Jaki zawod wykonujesz?'),
(8, 'Szkola', 'Chodzisz na korepetycje?'),
(9, 'Szkola', 'Jaka masz srednia ocen?');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `komentarze`
--

CREATE TABLE `komentarze` (
  `id_komentarza` int(11) NOT NULL,
  `tresc_komentarza` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `komentarze`
--

INSERT INTO `komentarze` (`id_komentarza`, `tresc_komentarza`) VALUES
(1, 'Nie obchodzi mnie '),
(2, 'Fajnie'),
(3, 'Srednio'),
(4, 'Dobre'),
(5, 'Zle'),
(6, 'Git'),
(7, 'Not'),
(8, 'Hehe');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `odpowiedzi`
--

CREATE TABLE `odpowiedzi` (
  `id_pytania` int(11) NOT NULL,
  `id_tresci_odpowiedzi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `odpowiedzi`
--

INSERT INTO `odpowiedzi` (`id_pytania`, `id_tresci_odpowiedzi`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 3),
(3, 4),
(3, 5),
(4, 6),
(4, 11),
(4, 12),
(4, 13),
(5, 14),
(5, 15),
(5, 16),
(5, 17),
(6, 1),
(6, 2),
(7, 18),
(7, 19),
(7, 20),
(7, 21),
(8, 1),
(8, 2),
(9, 22),
(9, 23),
(9, 24);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `odpowiedzi_osob`
--

CREATE TABLE `odpowiedzi_osob` (
  `id_odpowiedzi` int(11) NOT NULL,
  `id_osoby` int(11) NOT NULL,
  `id_pytania` int(11) NOT NULL,
  `id_tresci_odpowiedzi` int(11) DEFAULT NULL,
  `id_komentarza` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `odpowiedzi_osob`
--

INSERT INTO `odpowiedzi_osob` (`id_odpowiedzi`, `id_osoby`, `id_pytania`, `id_tresci_odpowiedzi`, `id_komentarza`) VALUES
(1, 1, 1, 1, 1),
(2, 1, 2, 1, 2),
(3, 1, 3, 5, 3),
(4, 1, 8, 1, 4),
(5, 2, 4, 11, 5),
(6, 2, 5, 15, 6),
(7, 2, 6, 1, 7),
(8, 2, 7, 20, 8);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `osoby`
--

CREATE TABLE `osoby` (
  `id_osoby` int(11) NOT NULL,
  `IPv4` varchar(15) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `osoby`
--

INSERT INTO `osoby` (`id_osoby`, `IPv4`) VALUES
(1, '3.145.58.15'),
(2, '145.25.235.65'),
(3, '12.45.45.45'),
(4, '12.15.12.455');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tresci_odpowiedzi`
--

CREATE TABLE `tresci_odpowiedzi` (
  `id_tresci_odpowiedzi` int(11) NOT NULL,
  `tresc_odpowiedzi` varchar(250) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `tresci_odpowiedzi`
--

INSERT INTO `tresci_odpowiedzi` (`id_tresci_odpowiedzi`, `tresc_odpowiedzi`) VALUES
(1, 'Tak'),
(2, 'Nie'),
(3, 'Matematyka'),
(4, 'Polski'),
(5, 'Informatyka'),
(6, 'od 2 do 4 godziny'),
(11, 'od 4 do 6 godzin'),
(12, 'od 6 do 8 godzin'),
(13, 'wiecej niz 8 godzi'),
(14, 'nie pracuje'),
(15, 'od 3 do 6k'),
(16, 'od 6 do 8k'),
(17, 'od 8 do 16k'),
(18, 'Ksiegowy'),
(19, 'Informatyk'),
(20, 'Lekarz'),
(21, 'Nauczyciel'),
(22, '2 - 4'),
(23, '4 - 5'),
(24, '5 - 6');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `ankiety`
--
ALTER TABLE `ankiety`
  ADD PRIMARY KEY (`ID_pytania`);

--
-- Indeksy dla tabeli `komentarze`
--
ALTER TABLE `komentarze`
  ADD PRIMARY KEY (`id_komentarza`),
  ADD UNIQUE KEY `id_komenatarza` (`id_komentarza`);

--
-- Indeksy dla tabeli `odpowiedzi`
--
ALTER TABLE `odpowiedzi`
  ADD PRIMARY KEY (`id_pytania`,`id_tresci_odpowiedzi`),
  ADD KEY `FKveh1qofslmby26qo49fqkr42` (`id_tresci_odpowiedzi`);

--
-- Indeksy dla tabeli `odpowiedzi_osob`
--
ALTER TABLE `odpowiedzi_osob`
  ADD PRIMARY KEY (`id_odpowiedzi`),
  ADD KEY `id_osoby` (`id_osoby`),
  ADD KEY `id_pytania` (`id_pytania`),
  ADD KEY `id_tresci_odpowiedzi` (`id_tresci_odpowiedzi`),
  ADD KEY `id_komenatrza` (`id_komentarza`);

--
-- Indeksy dla tabeli `osoby`
--
ALTER TABLE `osoby`
  ADD PRIMARY KEY (`id_osoby`);

--
-- Indeksy dla tabeli `tresci_odpowiedzi`
--
ALTER TABLE `tresci_odpowiedzi`
  ADD PRIMARY KEY (`id_tresci_odpowiedzi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `ankiety`
--
ALTER TABLE `ankiety`
  MODIFY `ID_pytania` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT dla tabeli `komentarze`
--
ALTER TABLE `komentarze`
  MODIFY `id_komentarza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `odpowiedzi_osob`
--
ALTER TABLE `odpowiedzi_osob`
  MODIFY `id_odpowiedzi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `osoby`
--
ALTER TABLE `osoby`
  MODIFY `id_osoby` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT dla tabeli `tresci_odpowiedzi`
--
ALTER TABLE `tresci_odpowiedzi`
  MODIFY `id_tresci_odpowiedzi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `odpowiedzi`
--
ALTER TABLE `odpowiedzi`
  ADD CONSTRAINT `FK9q79et5ppydugwvjwp2wq7778` FOREIGN KEY (`id_pytania`) REFERENCES `ankiety` (`ID_pytania`),
  ADD CONSTRAINT `FKveh1qofslmby26qo49fqkr42` FOREIGN KEY (`id_tresci_odpowiedzi`) REFERENCES `tresci_odpowiedzi` (`id_tresci_odpowiedzi`);

--
-- Ograniczenia dla tabeli `odpowiedzi_osob`
--
ALTER TABLE `odpowiedzi_osob`
  ADD CONSTRAINT `FKonv53wwus2xict06ddxu0r0qv` FOREIGN KEY (`id_komentarza`) REFERENCES `komentarze` (`id_komentarza`),
  ADD CONSTRAINT `odpowiedzi_osob_ibfk_1` FOREIGN KEY (`id_osoby`) REFERENCES `osoby` (`id_osoby`),
  ADD CONSTRAINT `odpowiedzi_osob_ibfk_2` FOREIGN KEY (`id_pytania`) REFERENCES `ankiety` (`ID_pytania`),
  ADD CONSTRAINT `odpowiedzi_osob_ibfk_3` FOREIGN KEY (`id_tresci_odpowiedzi`) REFERENCES `tresci_odpowiedzi` (`id_tresci_odpowiedzi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
