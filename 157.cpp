/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char *buf4);
 */

class Solution {
public:
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int read(char *buf, int n) {
        char buffer[4] = {0};
        int total_data_read = 0;
        int offset = 0;
        while(n > 0){
            int dataRead = read4(buffer);
            int count = std::min(dataRead, std::min(4, n));
            for(int i = 0; i<count; i++){
                buf[offset + i] = buffer[i];
            }
            total_data_read  += count;
            if(dataRead < 4){
                break;
            }
            offset += 4;
            n -= count;
        }
        return total_data_read;
    }
};
