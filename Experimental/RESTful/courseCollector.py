import bs4 as bs
import urllib.request

#First page
f = open("courseList", "w")
curPage, totalPage = 0, 1

#Loop through
while curPage < totalPage:
    source = urllib.request.urlopen('https://fas.calendar.utoronto.ca/search-courses?page='+ str(curPage)).read()
    soup = bs.BeautifulSoup(source,'lxml')

    #TODO: does some shit here
    for div in soup.find_all('td', class_='views-field views-field-title'):
        f.write(div.text)
    if totalPage == 1:
        totalPage = int(soup.find('li', class_='pager-current').text[5:])
    curPage += 1
    print("Onto page: " + str(curPage + 1))
f.close()
print("==============DONE==============")
