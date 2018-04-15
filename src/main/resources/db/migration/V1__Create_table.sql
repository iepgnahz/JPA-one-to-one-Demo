CREATE TABLE bookDetail (
    id int(10) NOT NULL,
    writer varchar(10) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book (
    id int(10) NOT NULL,
    bookDetailId int(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (bookDetailId) REFERENCES bookDetail(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

