CREATE TABLE `content_user_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `behavior_content` varchar(200) NOT NULL,
  `user_id_json` text NOT NULL,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `IDX_ADD_TIME` (`add_time`)
) ENGINE=InnoDB AUTO_INCREMENT=4281 DEFAULT CHARSET=latin1;

CREATE TABLE `item_simi_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(200) NOT NULL,
  `target_item_id` varchar(200) NOT NULL,
  `score` double NOT NULL,
  `add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `IDX_item_score` (`item_id`,`score`),
  KEY `IDX_add_date` (`add_date`)
) ENGINE=InnoDB AUTO_INCREMENT=2030200 DEFAULT CHARSET=latin1;

CREATE TABLE `title_simi_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title_id_a` varchar(200) NOT NULL,
  `title_id_b` varchar(200) NOT NULL,
  `score` double NOT NULL,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `IDX_a_b_s` (`title_id_a`,`title_id_b`,`score`),
  KEY `IDX_add_time` (`add_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
