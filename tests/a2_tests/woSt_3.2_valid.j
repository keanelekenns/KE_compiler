.class public woSt_3.2_valid
.super java/lang/Object

.method public static __main()V
    .limit locals 29
    .limit stack 50
;       T13 := NEWARRAY I 4
    ldc 4
    newarray int
    astore 13
;       T14 := 1
    ldc 1
    istore 14
;       T15 := 1
    ldc 1
    istore 15
;       T13[T14] := T15
    aload 13
    iload 14
    iload 15
    iastore
;       T16 := 1
    ldc 1
    istore 16
;       T17 := T13[T16]
    aload 13
    iload 16
    iaload
    istore 17
;       PRINTI T17
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 17
    invokevirtual java/io/PrintStream/print(I)V
;       T18 := "a"
    ldc "a"
    astore 18
;       T0 := T18
    aload 18
    astore 0
;       T19 := "b"
    ldc "b"
    astore 19
;       T1 := T19
    aload 19
    astore 1
;       T20 := T0 U+ T1
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
    aload 0
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 1
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    astore 20
;       T2 := T20
    aload 20
    astore 2
;       PRINTLNC T11
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 11
    invokevirtual java/io/PrintStream/println(C)V
;       T21 := 'a'
    ldc 97
    istore 21
;       T9 := T21
    iload 21
    istore 9
;       T22 := 'b'
    ldc 98
    istore 22
;       T10 := T22
    iload 22
    istore 10
;       T23 := T10 C- T9
    iload 10
    iload 9
    isub
    istore 23
;       T11 := T23
    iload 23
    istore 11
;       PRINTLNC T11
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 11
    invokevirtual java/io/PrintStream/println(C)V
;       T24 := 1.1
    ldc 1.1
    fstore 24
;       T6 := T24
    fload 24
    fstore 6
;       T25 := 2.2
    ldc 2.2
    fstore 25
;       T7 := T25
    fload 25
    fstore 7
;       T26 := T6 F* T7
    fload 6
    fload 7
    fmul
    fstore 26
;       T8 := T26
    fload 26
    fstore 8
;       PRINTLNF T8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    fload 8
    invokevirtual java/io/PrintStream/println(F)V
;       T27 := T9 C< T10
    iload 9
    iload 10
    isub
    iflt L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 27
;       T12 := T27
    iload 27
    istore 12
;       PRINTLNZ T12
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 12
    invokevirtual java/io/PrintStream/println(Z)V
;       T28 := T6 F== T7
    fload 6
    fload 7
    fcmpl
    ifeq L_2
    ldc 0
    goto L_3
L_2:
    ldc 1
L_3:
    istore 28
;       T12 := T28
    iload 28
    istore 12
;       PRINTLNZ T12
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 12
    invokevirtual java/io/PrintStream/println(Z)V
    return
.end method


;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;
.method public static main([Ljava/lang/String;)V
    ; set limits used by this method
    .limit locals 1
    .limit stack 4
    invokestatic woSt_3.2_valid/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method