.class public test5
.super java/lang/Object

.method public static foo(Ljava/lang/String;IFZC[F)F
    .limit locals 12
    .limit stack 50
;       T7 := 'e'
    ldc 101
    istore 7
;       T8 := T4 C+ T7
    iload 4
    iload 7
    iadd
    istore 8
;       T9 := 'r'
    ldc 114
    istore 9
;       T10 := T8 C+ T9
    iload 8
    iload 9
    iadd
    istore 10
;       T6 := T10
    iload 10
    istore 6
;       T11 := 434.4
    ldc 434.4
    fstore 11
;       RETURN T11
    fload 11
    freturn
.end method


.method public static __main()V
    .limit locals 10
    .limit stack 50
;       T0 := NEWARRAY F 40
    ldc 40
    newarray float
    astore 0
;       T2 := 34
    ldc 34
    istore 2
;       T1 := T2
    iload 2
    istore 1
;       T4 := "hi"
    ldc "hi"
    astore 4
;       T5 := 34.34
    ldc 34.34
    fstore 5
;       T6 := FALSE
    ldc 0
    istore 6
;       T7 := 'e'
    ldc 101
    istore 7
;       T3 := CALL foo(T4T1T5T6T7T0)
    aload 4
    iload 1
    fload 5
    iload 6
    iload 7
    aload 0
    invokestatic test5/foo(Ljava/lang/String;IFZC[F)F
    fstore 3
;       T8 := 32.4
    ldc 32.4
    fstore 8
;       T9 := T3 F- T8
    fload 3
    fload 8
    fsub
    fstore 9
;       PRINTF T9
    getstatic java/lang/System/out Ljava/io/PrintStream;
    fload 9
    invokevirtual java/io/PrintStream/print(F)V
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
    invokestatic test5/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method