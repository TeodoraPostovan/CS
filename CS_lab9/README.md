# Lab 9: CSRF Security
### Author: *Serghei Derevenco*
-----
## Objectives
1. Create a web application where the user can authenticate;
2. Implement CSRF protection for your web application;
3. Prove the effectiveness of implemented mechanisms (via video).
-----
## Technologies
* [Python](https://www.python.org/) programming language
* [Django](https://www.djangoproject.com/) framework
-----
## To Use
* Firstly, clone this repository using [Git](https://git-scm.com) or download `.zip` archive with project.  
* Secondly, if your OS is Windows, you will need to [install Python](https://realpython.com/installing-python/) language to be able to execute the project (In other types of OS [Python](https://www.python.org/) is installed by default).  
* Thirdly, using the following command `pip install django` or follow instructions from here: [install Django](https://docs.djangoproject.com/en/3.1/topics/install/).  
* Next, `cd` into `project/` directory and create a new virtual environment using `pipenv shell --python 3`.
* Finally, migrate the database `python3 manage.py migrate`, run the local server `python3 manage.py runserver` and enter the following link into your browser to see the app -  http://127.0.0.1:8000/login .
