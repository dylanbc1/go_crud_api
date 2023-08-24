import Pelicula
import Director

flag = True

listPeli = []
listDirect = []


def print_movies():
    for pelis in listPeli:
        print("Director: " + pelis.get_director())
        print("Year" + pelis.get_year())
        print("Genre: " + pelis.get_genre())
        print("-"*10)


def print_female_directors():
    msg = ""

    for director in listDirect:
        if(director.genre == "F"):
            msg += "Female Direc. | Name: " + director.name + ", Birth Date: " + director.birth_date + "\n"


def register_director(name, genre, birth_date, death_date):
    listDirect.append(Director(director_name, director_genre, director_birth_date, director_death_date))


def search_director(name):
    for director in listDirect:
        if director.name == name:
            return director

while flag:
    print("Menu")
    print("1. Register movie")
    print("2. See movies")
    print("3. Register director")
    print("4. Print female directors")
    print("5. exit")
    opt = int(input())
    if opt == 1:
        # director attributes
        director_name = input("Enter directors name: ")
        genre = input("Enter movie genre: ")
        year = input("Enter year: ")
        pel = Pelicula(search_director(director_name), genre, year)
        listPeli.append(pel)
        print("Movie saved")

    elif opt == 2:
        print_movies()
    elif opt == 3:
        director_name = input("Enter directors name: ")
        director_genre = input("Enter directors genre (M/F): ")
        director_birth_date = input("Enter directors birth date (DD/MM/AA): ")
        director_death_date = input("Enter directors death date (DD/MM/AA). "
                                    "Type 0 if he/she is still alive: ")
        register_director(director_name, director_genre, director_birth_date, director_death_date)
    elif opt == 4:
        print_female_directors()
    elif opt == 5:
        flag = False
