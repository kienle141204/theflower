-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: the_flower_shop
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `guest_id` varchar(45) DEFAULT NULL,
  `total_price` int(100) unsigned zerofill DEFAULT NULL,
  `product_id` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_item` (
  `id` int NOT NULL,
  `cart_id` int NOT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cart_id` (`cart_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `cart_id` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `id` int NOT NULL,
  `product_id` int DEFAULT NULL,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id_constraint` (`product_id`),
  CONSTRAINT `product_id_constraint` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,1,'mb'),(2,3,'mb'),(3,2,'mb'),(4,4,'mb'),(5,5,'mb'),(6,7,'mb'),(7,8,'mb'),(8,9,'mb'),(9,10,'mb'),(10,18,'mb'),(11,21,'ch'),(12,6,'ooak'),(13,11,'ooak'),(14,12,'ooak'),(15,13,'ooak'),(16,9,'so'),(17,18,'so'),(18,13,'so'),(19,13,'ss'),(20,14,'pl'),(21,16,'pl'),(22,17,'pl');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `description` longtext,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Pick Me Up','/image/flowers/TFW_PMUBright_6.jpg','A great way to show you care. A sweet mix of roses and daisies, send it to that special someone who could use a little ‘pick me up’.\n\nChoose from 2 sizes and 3 colours:\n\nBright\nPastel\nWhite\n Vessel is included. Florist will choose appropriate vase to suit. \n\nArrangement may vary from image as is dependent on stock availability (see our substitution policy).',780000,0),(2,'Kellie Bouquet','/image/flowers/TFW_Kellie_2.jpg','A small bouquet of fresh and seasonal blooms, selected by our wonderful team of florists. This posy is an all-rounder – perfect for any occasion! Large size pictured. Our florist will choose an appropriate vase to suit. Flower bouquet may vary from image as is dependent on stock availability (see our substitution policy).',1356000,11),(3,'Sunflower Bouquet','/image/flowers/TFW_SunflowerBouquet_1.jpg','The flower bouquet to make people smile! This happy arrangement is a combination of sunflowers and daisy chrysanthemums. Important note on sunflowers: Stock comes in fresh regularly so sunflowers may appear tighter and smaller than pictured. Large size pictured. Our florist will choose an appropriate vase to suit. Daisy colour may vary from image as is dependent on stock availability (see our substitution policy).',1356000,11),(4,'Jacqui Bouquet','/image/flowers/TFW_JacquiBouquetApricot_1.jpg','A big, beautiful mix of some of our favourite flowers including lilies, chrysanthemums and daisies. With 4 colours to choose from, we’ve got all occasions covered: White, Bright, Pastel, Apricot. Large size pictured. Our florist will choose an appropriate vase to suit. Flower bouquet may vary from image as is dependent on stock availability (see our substitution policy).',2268000,11),(5,'Viola Bouquet','/image/flowers/TFW_Viola_1.jpg','One of our most popular bouquets – and it’s easy to see why! Our Viola is an eclectic mix of all shades of pink, purple and white, and is sure to make anyone’s day. Celebrate a birthday, anniversary, graduation or just because! Want to make it even more special? Send it in a vase. Large size pictured. Florist will choose appropriate vase to suit. Bouquet may vary from image as is dependent on stock availability (see our substitution policy).',2316000,11),(6,'Natives',NULL,NULL,1116000,11),(7,'Bright Vase','/image/flowers/TFW_BrightVase_1.jpg','A gorgeous arrangement of vibrant blooms that is sure to make someone’s day. Vessel is included. Florist will choose appropriate vase to suit. Flower arrangement may vary from image as is dependent on stock availability (see our substitution policy).',2544000,11),(8,'Pastel Vase','/image/flowers/TFW_PastelVase_4.jpg','How do we show that we care? With flowers of course! This sweet arrangement is great for an office desk or hospital room. Vessel is included. Florist will choose appropriate vase to suit. Arrangement may vary from image as is dependent on stock availability (see our substitution policy).',2196000,11),(9,'Kate Bouquet','/image/flowers/TFW_KateBouquet_1.jpg','When traditional roses aren’t the right fit, our Kate Bouquet will tick all your boxes this Valentine’s or Mother\'s Day. A vibrant flower bouquet filled with bright chrysanthemums, green disbuds and button daisies and hot pink roses! Large size pictured.',2076000,11),(10,'Mixed Roses','/image/flowers/TFW_MixedRosesHotPalePink_3.jpg','No matter the occasion, you can’t go wrong with roses! Choose from 3 colour combinations: Hot Pink and Pale Pink, Pale Pink and White, Hot Pink and Orange. Large size pictured. Our florist will choose an appropriate vase to suit. Flower bouquet may vary from image as is dependent on stock availability (see our substitution policy).',2316000,11),(11,'Long Stem Red Roses','/image/flowers/TFW_LongStemRedRoses_5.jpg','There’s nothing quite like sending a bunch of long-stemmed red roses to that special someone. Whether it’s Valentine’s Day or ‘just because’, they are the quintessential romantic gift. Standard: 1 dozen, Large: 2 dozen. Rose colour may vary from image as is dependent on stock availability (see our substitution policy).',3228000,11),(12,'Oriental Lilies','/image/flowers/TFW_OrientalLilies_1.jpg','The forever elegant and heavenly scented Oriental Lily is the perfect choice for a perfume lover. Choose between white and pink lilies. Standard: 8 stems, Large: 16 stems. Stock comes in regularly so lilies will often be sent with closed buds.',1884000,11),(13,'Chrysanthemums','/image/flowers/TFW_Chrysanthemums_6.png','Chrysanthemums will have you floating on cloud nine, being both charmingly feathery and lasting longer than anyone will expect. A bunch of the fluffiest clouds anyone could ever dream of! Please keep in mind that Chrysanthemums are dyed – colour variations will vary. Standard: 5 stems, Large: 10 stems.',1308000,11),(14,'Peace Lily','/image/flowers/TFW_PeaceLily_1.jpg','Wanting to gift a low maintenance plant? A Peace Lily is the right choice! Beautiful white flowers, with dark green leaves; choose from 2 sizes.',780000,11),(15,'Single Rose',NULL,NULL,600000,11),(16,'Potted Phalaenopsis Orchid','/image/flowers/TFW_PottedPhalaenopsis_1.jpg','So, you want to send something stylish, elegant, and sophisticated? This stunning phalaenopsis orchid is exactly that. This amazing plant is easy to take care of and brings life to any home or workspace. Available in 2 colours.',1800000,11),(17,'Terrarium','','A terrarium is the ultimate, low-maintenance indoor garden. Watch this miniature world of succulents slowly grow and flourish.',1980000,11),(18,'Emily Bouquet','/image/flowers/TFW_Emily_4.jpg','Combining the elegance of white and green flowers with a pop of pink, this is fun twist on a classic bouquet. Large size pictured.',2208000,11),(19,'Bird in Hand Sparkling',NULL,NULL,960000,11),(20,'Lindt Lindor Milk Chocolate Box',NULL,NULL,840000,11),(21,'Real Christmas Tree','/image/flowers/christmas.png','Bring the magic of the festive season into your home with premium real Christmas trees from The Flower Web. Handpicked for their vibrant greenery and symmetrical shape, our fresh trees are the perfect centerpiece for your holiday celebrations. Available in three versatile sizes to complement any space:\n\n~ Small (65cm)\n~ Medium (85cm)\n~ Large (95cm)\n\nIdeal for family gatherings, office festivities, or retail displays, The Flower Web’s Christmas Trees add natural elegance and a warm holiday atmosphere to any setting.\n\nOrder your real Christmas tree today and enjoy delivery across Adelaide, making your holiday decorating effortless and stress-free.\n\nKeywords: real Christmas trees Adelaide, fresh holiday trees, Adelaide tree delivery, Christmas décor Adelaide, small medium large Christmas trees, holiday greenery.',700000,11);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-06 14:44:40
