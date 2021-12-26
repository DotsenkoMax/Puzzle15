Результаты для 2x2, 3x3, 4x4. 

Algo with n = 2, a = 1, b = 0  
Max moves: 6  
Mean moves: 3.087  
Max time (secs): 0.003  
Mean time (secs): 2.9E-5  
--------------------------------------------------------------------
Algo with n = 2, a = 1, b = 1  
Max moves: 6  
Mean moves: 2.92  
Max time (secs): 0.001  
Mean time (secs): 8.0E-6  
--------------------------------------------------------------------
Algo with n = 3, a = 1, b = 0  
Max moves: 198  
Mean moves: 67.761  
Max time (secs): 0.005  
Mean time (secs): 0.001125  
--------------------------------------------------------------------
Algo with n = 3, a = 1, b = 1  
Max moves: 30  
Mean moves: 22.357  
Max time (secs): 0.123  
Mean time (secs): 0.010417999999999998  
--------------------------------------------------------------------
Algo with n = 3, a = 1, b = 2  
Max moves: 29  
Mean moves: 21.924  
Max time (secs): 0.387  
Mean time (secs): 0.051675  
--------------------------------------------------------------------
Algo with n = 3, a = 1, b = 10  
Max moves: 30  
Mean moves: 21.838  
Max time (secs): 0.964  
Mean time (secs): 0.280114  
--------------------------------------------------------------------
Algo with n = 4, a = 1, b = 0  
Max moves: 600  
Mean moves: 283.19  
Max time (secs): 1.442  
Mean time (secs): 0.131339  
--------------------------------------------------------------------
Algo with n = 5, a = 1, b = 0  
Successful trials  8/10 (80.0%)  
Max moves: 1100  
Mean moves: 816.875  
Max time (secs): 19.254  
Mean time (secs): 9.85525  
--------------------------------------------------------------------
Для n = 2, 3 при больших b решается в пределах алгоритма Бога (https://ru.wikipedia.org/wiki/%D0%98%D0%B3%D1%80%D0%B0_%D0%B2_15#%D0%9C%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5_%D0%BE%D0%BF%D0%B8%D1%81%D0%B0%D0%BD%D0%B8%D0%B5).  
В случае с n = 4, запускать для b = 1 уже становится долго. 


Для 5x5 иногда падает GC (где - то в 10 % случаях). 