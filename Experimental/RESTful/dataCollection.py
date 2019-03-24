import bs4 as bs
import urllib.request
import sqlite3
import os

fileDir = os.path.dirname(os.path.realpath('__file__'))

#For accessing the file in a folder contained in the current folder

# Creates or opens a file called uToronto with a SQLite3 DB
db = sqlite3.connect(os.path.join(fileDir, 'data\\feedme.db'))
counter, total = 0,0
invalids = []

# Creates table
cursor = db.cursor()
cursor.execute('''
    CREATE TABLE IF NOT EXISTS courses(id INTEGER PRIMARY KEY,
    courseCode TEXT,
    program TEXT)
''')
db.commit()

#First page
f = open(os.path.join(fileDir, 'data\\courseList'), "r")
current = f.readline().strip()
print(current)

def insertDB(soup, course):
    global counter, total
    counter += 1
    total += 1

    ################
    titleFind = soup.find('h1', class_='title')
    titleText = titleFind.text.strip()
    parsedTitle = titleText[titleText.find(' ') + 1:]
    hours = soup.find('div', class_='field field-name-field-hours field-type-text field-label-inline clearfix')
    summary = soup.find('div', class_='field field-name-body field-type-text-with-summary field-label-hidden')
    prerecquisites = soup.find('div', class_='field field-name-field-prerequisite1 field-type-text-with-summary field-label-inline clearfix')
    exclusions = soup.find('div', class_='field field-name-field-exclusion1 field-type-text-with-summary field-label-inline clearfix')
    distribution = soup.find('div', class_='field field-name-field-distribution-req field-type-list-text field-label-inline clearfix')
    breadth = soup.find('div', class_='field field-name-field-breadth-req field-type-list-text field-label-inline clearfix')
    program = soup.find('div', class_='field field-name-field-section-link field-type-text-with-summary field-label-inline clearfix')
    ################


    cursor = db.cursor()
    cursor.execute('''INSERT INTO courses(courseCode, title, hours, summary, prerecquisites, exclusions, distribution, breadth, program)
                  VALUES(?,?,?,?,?,?,?,?,?)''', (course,
                                              parsedTitle if titleFind else "NULL",
                                              hours.text if hours else "NULL",
                                              summary.text.strip() if summary else "NULL",
                                              prerecquisites.text.strip() if prerecquisites else "NULL",
                                              exclusions.text.strip() if exclusions else "NULL",
                                              distribution.text if distribution else "NULL",
                                              breadth.text if breadth else "NULL",
                                              program.text.strip() if program else "NULL"))

    db.commit()
    print("{0} inserted".format(course.split()))

if __name__ == "__main__":

    while current:
        source = urllib.request.urlopen('https://fas.calendar.utoronto.ca/course/'+ current).read()
        soup = bs.BeautifulSoup(source,'lxml')

        if soup.title.text[0:5] == "Sorry": # Error checking
            print("Course Code invalid: {0}\n".format(current))
            invalids.append(current)
            current = f.readline()
            total += 1
        else:
            insertDB(soup, current)
            current = f.readline().strip()
            print(current)

    print("{0} out of {1} successful insert".format(counter, total))
    db.close()
    f.close()
    print("==============DONE==============")
