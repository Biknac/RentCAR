

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `car_list` (
  `id_car` int(10) NOT NULL,
  `type_car` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `number_сar_total` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO `car_list` (`id_car`, `type_car`, `number_сar_total`) VALUES
(1, 'cabrio', 5),
(2, 'hatchback', 10),
(3, 'muscle', 2),
(4, 'sedan', 15);


CREATE TABLE `order_list` (
  `id_order` int(10) NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_car` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO `order_list` (`id_order`, `email`, `name`, `id_car`) VALUES
(1, 'test@mail.com', 'Test', 4),
(2, 'test2@mail.com', 'Test2', 2),
(3, 'test3@mail.com', 'Test3', 4),
(4, 'test4@mail.com', 'Test4', 4),
(5, 'test5@mail.com', 'Test5', 1),
(6, 'test6@mail.com', 'Test6', 1);


ALTER TABLE `car_list`
  ADD PRIMARY KEY (`id_car`);


ALTER TABLE `order_list`
  ADD PRIMARY KEY (`id_order`);


ALTER TABLE `car_list`
  MODIFY `id_car` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;


ALTER TABLE `order_list`
  MODIFY `id_order` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

