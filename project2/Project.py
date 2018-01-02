from os import path
from scipy.misc import imread
import matplotlib.pyplot as plt
import random
from wordcloud import WordCloud, STOPWORDS
import string
import pandas as pd
import wordcloud as wc
from sklearn.feature_extraction.text \
import CountVectorizer, TfidfVectorizer
document = []
stopwords = []
mostfreq50 = []
indexof50 = []
wordfreq = []
filename =""
with open('inp.txt',"r") as f:
    for line in f:
        for word in line.split():
            word = word.lower()#lower case
            word = "".join((char for char in word if char not in string.punctuation ))               #remove punctuation
            result = ''.join([i for i in word if not i.isdigit() and isinstance(word,str)])           #remove digits
            if not result == '' and not  result == '•':
                document.append(result)  # take result
f.close()
with open('3.txt',"r") as f:
    for line in f:
        for word in line.split():
            word = word.lower()#lower case
            word = "".join((char for char in word if char not in string.punctuation ))               #remove punctuation
            result = ''.join([i for i in word if not i.isdigit() and isinstance(word,str)])           #remove digits
            if not result == '' and not  result == '•':
                document.append(result)  # take result
f.close()
with open('2.txt',"r") as f:
    for line in f:
        for word in line.split():
            word = word.lower()#lower case
            word = "".join((char for char in word if char not in string.punctuation ))               #remove punctuation
            result = ''.join([i for i in word if not i.isdigit() and isinstance(word,str)])           #remove digits
            if not result == '' and not  result == '•':
                document.append(result)  # take result
f.close()
with open('1.txt',"r") as f:
    for line in f:
        for word in line.split():
            word = word.lower()#lower case
            word = "".join((char for char in word if char not in string.punctuation ))               #remove punctuation
            result = ''.join([i for i in word if not i.isdigit() and isinstance(word,str)])           #remove digits
            if not result == '' and not  result == '•':
                document.append(result)  # take result
f.close()

with open('doc.txt',"r") as f:
    for line in f:
        for word in line.split():
            word = word.lower()                         #lower case
            word = "".join((char for char in word if char not in string.punctuation ))               #remove punctuation
            result = ''.join([i for i in word if not i.isdigit() and isinstance(word,str)])           #remove digits
            if not result == '' and not  result == '•':
                document.append(result)  # take result
f.close()
with open('stopwords.txt','r') as g:
    for line in g:
        for word in line.split():
           stopwords.append(word)
g.close()
i = 0
while i < len(document):
    x = 0
    while x < len(stopwords):
        if document[i] == stopwords[x]:
            document[i:i+1] = []
            i = i - 1
        x = x + 1
    i = i + 1
cv = CountVectorizer()
cv_fit = cv.fit_transform(document)
freqs = [(word, cv_fit.getcol(idx).sum()) for word, idx in cv.vocabulary_.items()]
freqs = sorted (freqs, key = lambda x: -x[1])
freqs = freqs[:50]
df = pd.DataFrame(data=freqs)
numpy = df.as_matrix()
df.to_csv("out2.csv")
print(numpy)
#print(cv.get_feature_names())
#print(cv_fit.toarray().sum(axis=0))
'''
for w in document:
    wordfreq.append(document.count(w))
'''
'''
z = 0
while (z < 50):
    c = wordfreq.index(max(wordfreq))
    mostfreq50.append(document[c])
    indexof50.append(max(wordfreq))
    document = [x for x in document if x != document[c]]
    wordfreq = [q for q in wordfreq if q != wordfreq[c]]
    z = z + 1
print(mostfreq50)
print(indexof50)
'''
ctfidfv = TfidfVectorizer()
ctfidfv_fit = ctfidfv.fit_transform(document)
freqsidf = [(word, ctfidfv_fit.getcol(idx).sum()) for word, idx in ctfidfv.vocabulary_.items()]
freqsidf = sorted(freqsidf, key=lambda x: -x[1])
freqsidf = freqsidf[:50]
dif = pd.DataFrame(data=freqsidf)
numpyidf = dif.as_matrix()
print(numpyidf)
dif.to_csv("out.csv")
filename="tfwordcloud.pdf"
wordcloud = WordCloud(
                      relative_scaling = 1.0,
                      stopwords = {'to', 'of'} # set or space-separated string
                      ).generate(str(numpyidf))
plt.figure(figsize=(20, 10), facecolor='k')
plt.imshow(wordcloud)
plt.axis("off")
plt.savefig(filename, facecolor='k', bbox_inches='tight')
filename ="tfidfwordcloud.pdf"
wordcloud2 = WordCloud(
                      relative_scaling = 1.0,
                      stopwords = {'to', 'of'} # set or space-separated string
                      ).generate(str(numpy))
plt.figure(figsize=(20, 10), facecolor='k')
plt.imshow(wordcloud2)
plt.axis("off")
plt.savefig(filename, facecolor='k', bbox_inches='tight')