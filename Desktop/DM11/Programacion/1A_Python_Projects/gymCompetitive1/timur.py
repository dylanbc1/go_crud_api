for i in range(0, int(input())):
  lista = list(map(int, input().split()))
  print(len(list(filter(lambda x: True if(x > lista[0]) else False, lista))))